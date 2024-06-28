
```Dockerfile
FROM harbor.test.hihonor.com/base-image/cuda12.2-devel-ubuntu20.04:v1.0

ENV http_proxy http://proxysys.his.hihonor.com:8080
ENV https_proxy http://proxysys.his.hihonor.com:8080
ENV CUDA_HOME=/usr/local/cuda

RUN mkdir -p /opt/miniconda3/
RUN apt-get update && apt-get install wget -y && wget https://mirrors.tuna.tsinghua.edu.cn/anaconda/miniconda/Miniconda3-py310_23.3.1-0-Linux-x86_64.sh -O /opt/miniconda3/miniconda.sh
RUN bash /opt/miniconda3/miniconda.sh -b -u -p /opt/miniconda3
RUN /opt/miniconda3/bin/conda init bash
RUN /opt/miniconda3/bin/conda init zsh
RUN rm -rf /opt/miniconda3/miniconda.sh

ENV PATH /opt/miniconda3/bin:$PATH

RUN apt-get update

RUN pip install accelerate==0.30.0 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install torch==2.1.2 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install torchaudio==2.1.2 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install torchvision==0.16.2 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install transformers==4.41.1 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install deepspeed==0.14.2 -i https://mirrors.aliyun.com/pypi/simple/

RUN pip install sentencepiece==0.1.99 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install protobuf==3.20.3 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install datasets==2.14.7 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install peft==0.7.1 -i https://mirrors.aliyun.com/pypi/simple/

RUN apt-get update

RUN apt-get install git -y
RUN pip install flash-attn==2.4.2 -i https://mirrors.aliyun.com/pypi/simple/

RUN pip install wandb==0.15.7 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install transformers-stream-generator==0.0.4 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install optimum==1.19.0 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install tiktoken==0.7.0 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install bitsandbytes==0.43.1 -i https://mirrors.aliyun.com/pypi/simple/
RUN pip install auto_gptq==0.7.1 -i https://mirrors.aliyun.com/pypi/simple/

RUN apt install -y infiniband-diags perftest ibverbs-providers libibumad3 libibverbs1 libnl-3-200 libnl-route-3-200 librdmacm1
RUN apt install -y pdsh libaio-dev lsof

ENV LD_LIBRARY_PATH /usr/local/cuda/extras/CUPTI/lib64:/usr/local/cuda/lib64:$LD_LIBRARY_PATH

WORKDIR /



```

```python

"""
A controller manages distributed workers.
It sends worker addresses to clients.
"""
import argparse
import asyncio
import dataclasses
from enum import Enum, auto
import json
import logging
import time
from typing import List, Union
import threading

from fastapi import FastAPI, Request
from fastapi.responses import StreamingResponse
import numpy as np
import requests
import uvicorn
import time

from constants import CONTROLLER_HEART_BEAT_EXPIRATION
from utils import build_logger, server_error_msg


logger = build_logger("controller", "controller.log")


# class DispatchMethod(Enum):
#     LOTTERY = auto()
#     SHORTEST_QUEUE = auto()

#     @classmethod
#     def from_str(cls, name):
#         if name == "lottery":
#             return cls.LOTTERY
#         elif name == "shortest_queue":
#             return cls.SHORTEST_QUEUE
#         else:
#             raise ValueError(f"Invalid dispatch method")

class Controller:
    def __init__(self):
        self.worker_info_dict = {}
        threading.Thread(target=self._check_works).start()

    def _check_works(self):
        while True:
            del_worker = []
            for model_name in self.worker_info_dict:
                if time.time() - self.worker_info_dict[model_name]["time"] > 60:
                    del_worker.append(model_name)
            if del_worker:
                for model_name in del_worker:
                    logger.info(f"del {model_name} for {self.worker_info_dict[model_name]['tab']}")
                    del self.worker_info_dict[model_name]

            time.sleep(90)
    
    def register_worker(self, data):
        model_name = data["model_name"]
        if model_name not in self.worker_info_dict:
            data.update({'time':time.time()})
            self.worker_info_dict[model_name] = data
            logger.info(f"{model_name} register for {data['tab']}, info:{data}")
            return 'ok'
        else:
            logger.info(f"{model_name} already_existed")
            return 'already_existed'
        
    def heart_beat(self, data):
        model_name = data["model_name"]
        if model_name in self.worker_info_dict:
            self.worker_info_dict[model_name]["time"] = time.time()
            logger.info(f"{model_name} beat")
        else:
            self.register_worker(data)
            logger.info(f"{model_name} reregister")

    def get_address_by_name(self, model_name):
        worker_address = self.worker_info_dict[model_name]['worker_address']
        logger.info(f"get {model_name} address: {worker_address}")
        return worker_address
    
    def get_models_by_tab(self, tab):
        model_names = []
        for model_name in self.worker_info_dict:
            if tab in self.worker_info_dict[model_name]['tab']:
                model_names.append(model_name)
        logger.info(f"get {tab} model names: {model_names}")
        return model_names



app = FastAPI()


@app.post("/register_worker")
async def register_worker(request: Request):
    data = await request.json()
    result = controller.register_worker(data)
    return {'response': result}

@app.post("/heart_beat")
async def heart_beat(request: Request):
    data = await request.json()
    controller.heart_beat(data)

# @app.post("/refresh_all_workers")
# async def refresh_all_workers():
#     models = controller.refresh_all_workers()


@app.post("/list_models")
async def list_models(request: Request):
    data = await request.json()
    model_names = controller.get_models_by_tab(data['tab'])
    return {"model_names": model_names}


@app.post("/get_worker_address")
async def get_worker_address(request: Request):
    data = await request.json()
    print("---data---")
    print(data)
    addr = controller.get_address_by_name(data["model"])
    return {"address": addr}


# @app.post("/receive_heart_beat")
# async def receive_heart_beat(request: Request):
#     data = await request.json()
#     exist = controller.receive_heart_beat(
#         data["worker_name"], data["queue_length"])
#     return {"exist": exist}


# @app.post("/worker_generate_stream")
# async def worker_api_generate_stream(request: Request):
#     params = await request.json()
#     generator = controller.worker_api_generate_stream(params)
#     return StreamingResponse(generator)


# @app.post("/worker_get_status")
# async def worker_api_get_status(request: Request):
#     return controller.worker_api_get_status()


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--host", type=str, default="0.0.0.0")
    parser.add_argument("--port", type=int, default=21001)

    args = parser.parse_args()
    logger.info(f"args: {args}")

    controller = Controller()
    uvicorn.run(app, host=args.host, port=args.port, log_level="info")



```
