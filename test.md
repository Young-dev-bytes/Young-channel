
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
