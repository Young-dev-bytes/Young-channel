this is a test
```yaml
kubectl describe pod job-1a581d5343514efab422ec0e6cc8151a-pytorch-job-master-0 -n sft-test

Name:             job-1a581d5343514efab422ec0e6cc8151a-pytorch-job-master-0
Namespace:        sft-test
Priority:         0
Service Account:  default
Node:             ai-k8s-node-pscjb-a800-gpu-05/192.168.200.64
Start Time:       Fri, 21 Jun 2024 09:29:19 +0800
Labels:           athena-job-name=job-1a581d5343514efab422ec0e6cc8151a
                  athena-task-type=sft
                  volcano.sh/job-name=job-1a581d5343514efab422ec0e6cc8151a
                  volcano.sh/job-namespace=sft-test
                  volcano.sh/queue-name=sft
                  volcano.sh/task-spec=pytorch-job-master
Annotations:      scheduling.k8s.io/group-name: job-1a581d5343514efab422ec0e6cc8151a-754cca77-ac95-4b00-8f8b-f2d39f4e4804
                  volcano.sh/job-name: job-1a581d5343514efab422ec0e6cc8151a
                  volcano.sh/job-version: 0
                  volcano.sh/queue-name: sft
                  volcano.sh/task-spec: pytorch-job-master
                  volcano.sh/template-uid: job-1a581d5343514efab422ec0e6cc8151a-pytorch-job-master
Status:           Running
IP:               192.168.200.64
IPs:
  IP:           192.168.200.64
Controlled By:  Job/job-1a581d5343514efab422ec0e6cc8151a
Init Containers:
  athena-init-container:
    Container ID:  containerd://9148ad252861ee2cc878b488bb4d58766291e0e1c4de9c1dee403f99f14f89bd
    Image:         harbor.test.hihonor.com/library/ubuntu-init:18.04
    Image ID:      harbor.test.hihonor.com/library/ubuntu-init@sha256:0d89bbf299f4d054ff2759769f755b3ec08336072a83621f825774b4a2fe05b0
    Port:          <none>
    Host Port:     <none>
    Command:
      /bin/sh
    Args:
      -c
      cp /opt/share/code/custimize_sft_test_06_V1_1a581d5343514efab422ec0e6cc8151a.tar.gz /opt/code  && tar -xvf /opt/code/custimize_sft_test_06_V1_1a581d5343514efab422ec0e6cc8151a.tar.gz --strip-components=1 -C /opt/code 
    State:          Terminated
      Reason:       Completed
      Exit Code:    0
      Started:      Fri, 21 Jun 2024 09:29:33 +0800
      Finished:     Fri, 21 Jun 2024 09:29:33 +0800
    Ready:          True
    Restart Count:  0
    Limits:
      cpu:     500m
      memory:  50Mi
    Requests:
      cpu:     100m
      memory:  10Mi
    Environment:
      VC_PYTORCH_JOB_MASTER_HOSTS:  <set to the key 'VC_PYTORCH_JOB_MASTER_HOSTS' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>  Optional: false
      VC_PYTORCH_JOB_MASTER_NUM:    <set to the key 'VC_PYTORCH_JOB_MASTER_NUM' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>    Optional: false
      VC_PYTORCH_JOB_WORKER_HOSTS:  <set to the key 'VC_PYTORCH_JOB_WORKER_HOSTS' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>  Optional: false
      VC_PYTORCH_JOB_WORKER_NUM:    <set to the key 'VC_PYTORCH_JOB_WORKER_NUM' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>    Optional: false
    Mounts:
      /dev/shm from cache-volume (rw)
      /etc/volcano from job-1a581d5343514efab422ec0e6cc8151a-svc (rw)
      /opt/code from 1a581d5343514efab422ec0e6cc8151a-algo (rw)
      /opt/input/data/multi_train from 1a581d5343514efab422ec0e6cc8151a-sft-dataset-nas (ro)
      /opt/input/model from 1a581d5343514efab422ec0e6cc8151a-qwen-7b-20240516-v1 (rw)
      /opt/output from 1a581d5343514efab422ec0e6cc8151a-output (rw)
      /opt/share/code from 1a581d5343514efab422ec0e6cc8151a-share-algo (rw)
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-8f4pn (ro)
Containers:
  pytorch-job-master-container-0:
    Container ID:  containerd://38c6c383b826129689c433821c54df4fe14a8ccae04a480bcf24646258905294
    Image:         harbor.test.hihonor.com/base-image/fastchat-deepspeed-lite:v2.1
    Image ID:      harbor.test.hihonor.com/base-image/fastchat-deepspeed-lite@sha256:2a05e3bacd52be7493d194f8d1891fb3d38b56b3c99b8b0fbaf37a22c4f8d480
    Port:          31960/TCP
    Host Port:     31960/TCP
    Command:
      /bin/bash
      -c
      echo "nameserver 10.96.0.10
      search sft-test.svc.cluster.local svc.cluster.local cluster.local" >  /etc/resolv.conf
      mkdir -p /var/run/sshd
      /usr/sbin/sshd
      source ~/.bashrc
      conda activate flash
      nvidia-smi
      bash /opt/code/LLM-Pruner/fastchat/fastchat_dp.sh /opt/input/model 2 2 2.0E-5 3 true false 6 'cosine' 0.1 1250 2048 true 200 100 10 '<|im_start|>' '<|im_end|>' 'qwen_7b' true '/opt/input/data/multi_train'
    State:          Running
      Started:      Fri, 21 Jun 2024 09:29:34 +0800
    Ready:          True
    Restart Count:  0
    Limits:
      cpu:             60
      memory:          536870912k
      nvidia.com/gpu:  8
    Requests:
      cpu:             60
      memory:          536870912k
      nvidia.com/gpu:  8
    Environment:
      JOB_ID:                       1a581d5343514efab422ec0e6cc8151a
      MASTER_ADDR:                  job-1a581d5343514efab422ec0e6cc8151a-pytorch-job-master-0.job-1a581d5343514efab422ec0e6cc8151a
      MASTER_PORT:                  31960
      WORLD_SIZE:                   2
      RANK:                         0
      VC_PYTORCH_JOB_MASTER_HOSTS:  <set to the key 'VC_PYTORCH_JOB_MASTER_HOSTS' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>  Optional: false
      VC_PYTORCH_JOB_MASTER_NUM:    <set to the key 'VC_PYTORCH_JOB_MASTER_NUM' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>    Optional: false
      VC_PYTORCH_JOB_WORKER_HOSTS:  <set to the key 'VC_PYTORCH_JOB_WORKER_HOSTS' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>  Optional: false
      VC_PYTORCH_JOB_WORKER_NUM:    <set to the key 'VC_PYTORCH_JOB_WORKER_NUM' of config map 'job-1a581d5343514efab422ec0e6cc8151a-svc'>    Optional: false
    Mounts:
      /dev/shm from cache-volume (rw)
      /etc/volcano from job-1a581d5343514efab422ec0e6cc8151a-svc (rw)
      /opt/code from 1a581d5343514efab422ec0e6cc8151a-algo (rw)
      /opt/input/data/multi_train from 1a581d5343514efab422ec0e6cc8151a-sft-dataset-nas (ro)
      /opt/input/model from 1a581d5343514efab422ec0e6cc8151a-qwen-7b-20240516-v1 (rw)
      /opt/output from 1a581d5343514efab422ec0e6cc8151a-output (rw)
      /opt/share/code from 1a581d5343514efab422ec0e6cc8151a-share-algo (rw)
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-8f4pn (ro)
Conditions:
  Type              Status
  Initialized       True 
  Ready             True 
  ContainersReady   True 
  PodScheduled      True 
Volumes:
  1a581d5343514efab422ec0e6cc8151a-share-algo:
    Type:       PersistentVolumeClaim (a reference to a PersistentVolumeClaim in the same namespace)
    ClaimName:  1a581d5343514efab422ec0e6cc8151a-share-algo
    ReadOnly:   false
  1a581d5343514efab422ec0e6cc8151a-algo:
    Type:       PersistentVolumeClaim (a reference to a PersistentVolumeClaim in the same namespace)
    ClaimName:  1a581d5343514efab422ec0e6cc8151a-algo
    ReadOnly:   false
  1a581d5343514efab422ec0e6cc8151a-output:
    Type:       PersistentVolumeClaim (a reference to a PersistentVolumeClaim in the same namespace)
    ClaimName:  1a581d5343514efab422ec0e6cc8151a-output
    ReadOnly:   false
  1a581d5343514efab422ec0e6cc8151a-sft-dataset-nas:
    Type:      NFS (an NFS mount that lasts the lifetime of a pod)
    Server:    10.69.179.245
    Path:      /finetune/datasets/bbb5c0faa8d60aee7e9001ec362b2123/multi_train
    ReadOnly:  true
  1a581d5343514efab422ec0e6cc8151a-qwen-7b-20240516-v1:
    Type:       PersistentVolumeClaim (a reference to a PersistentVolumeClaim in the same namespace)
    ClaimName:  1a581d5343514efab422ec0e6cc8151a-qwen-7b-20240516-v1
    ReadOnly:   false
  cache-volume:
    Type:       EmptyDir (a temporary directory that shares a pod's lifetime)
    Medium:     Memory
    SizeLimit:  <unset>
  job-1a581d5343514efab422ec0e6cc8151a-svc:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      job-1a581d5343514efab422ec0e6cc8151a-svc
    Optional:  false
  kube-api-access-8f4pn:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    ConfigMapOptional:       <nil>
    DownwardAPI:             true
QoS Class:                   Burstable
Node-Selectors:              volcano.scheduler/queue=sft
Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:                      <none>


```
