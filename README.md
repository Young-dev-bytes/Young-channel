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


```yaml

kubectl describe node ai-k8s-node-pscjb-a800-gpu-05
Name:               ai-k8s-node-pscjb-a800-gpu-05
Roles:              <none>
Labels:             beta.kubernetes.io/arch=amd64
                    beta.kubernetes.io/os=linux
                    distributed=enable
                    kubernetes.io/arch=amd64
                    kubernetes.io/hostname=ai-k8s-node-pscjb-a800-gpu-05
                    kubernetes.io/os=linux
                    nodeRole=worker
                    nodeType=gpu
                    nvidia-gpu=true
                    nvidia.com/gpu.present=true
                    scale=true
                    sft-test/tenantInfo=sft-new
                    volcano.scheduler/queue=sft
Annotations:        csi.volume.kubernetes.io/nodeid: {"spectrumscale.csi.ibm.com":"ai-k8s-node-pscjb-a800-gpu-05"}
                    flannel.alpha.coreos.com/backend-data: {"VNI":1,"VtepMAC":"ea:00:58:23:ef:02"}
                    flannel.alpha.coreos.com/backend-type: vxlan
                    flannel.alpha.coreos.com/kube-subnet-manager: true
                    flannel.alpha.coreos.com/public-ip: 10.162.197.17
                    kubeadm.alpha.kubernetes.io/cri-socket: unix:///var/run/containerd/containerd.sock
                    node.alpha.kubernetes.io/ttl: 0
                    volumes.kubernetes.io/controller-managed-attach-detach: true
CreationTimestamp:  Mon, 20 May 2024 15:15:52 +0800
Taints:             <none>
Unschedulable:      false
Lease:
  HolderIdentity:  ai-k8s-node-pscjb-a800-gpu-05
  AcquireTime:     <unset>
  RenewTime:       Fri, 21 Jun 2024 17:44:00 +0800
Conditions:
  Type                 Status  LastHeartbeatTime                 LastTransitionTime                Reason                       Message
  ----                 ------  -----------------                 ------------------                ------                       -------
  NetworkUnavailable   False   Mon, 20 May 2024 15:15:56 +0800   Mon, 20 May 2024 15:15:56 +0800   FlannelIsUp                  Flannel is running on this node
  MemoryPressure       False   Fri, 21 Jun 2024 17:40:06 +0800   Mon, 20 May 2024 15:15:52 +0800   KubeletHasSufficientMemory   kubelet has sufficient memory available
  DiskPressure         False   Fri, 21 Jun 2024 17:40:06 +0800   Mon, 03 Jun 2024 10:07:24 +0800   KubeletHasNoDiskPressure     kubelet has no disk pressure
  PIDPressure          False   Fri, 21 Jun 2024 17:40:06 +0800   Mon, 20 May 2024 15:15:52 +0800   KubeletHasSufficientPID      kubelet has sufficient PID available
  Ready                True    Fri, 21 Jun 2024 17:40:06 +0800   Mon, 20 May 2024 15:15:54 +0800   KubeletReady                 kubelet is posting ready status. AppArmor enabled
Addresses:
  InternalIP:  192.168.200.64
  Hostname:    ai-k8s-node-pscjb-a800-gpu-05
Capacity:
  cpu:                          128
  ephemeral-storage:            453537296Ki
  hugepages-1Gi:                0
  hugepages-2Mi:                0
  memory:                       2113572184Ki
  nvidia.com/gpu:               8
  pods:                         110
  rdma/hca_shared_devices_ib1:  100
  rdma/hca_shared_devices_ib2:  100
  rdma/hca_shared_devices_ib3:  100
  rdma/hca_shared_devices_ib4:  100
  rdma/hca_shared_devices_ib5:  100
  rdma/hca_shared_devices_ib6:  100
  rdma/hca_shared_devices_ib7:  100
  rdma/hca_shared_devices_ib8:  100
Allocatable:
  cpu:                          128
  ephemeral-storage:            417979971302
  hugepages-1Gi:                0
  hugepages-2Mi:                0
  memory:                       2113469784Ki
  nvidia.com/gpu:               8
  pods:                         110
  rdma/hca_shared_devices_ib1:  100
  rdma/hca_shared_devices_ib2:  100
  rdma/hca_shared_devices_ib3:  100
  rdma/hca_shared_devices_ib4:  100
  rdma/hca_shared_devices_ib5:  100
  rdma/hca_shared_devices_ib6:  100
  rdma/hca_shared_devices_ib7:  100
  rdma/hca_shared_devices_ib8:  100
System Info:
  Machine ID:                    a8a90d3f4cf74bb496051f6b67f680f6
  System UUID:                   79a8f9b2-3473-951e-ee11-f47d66134106
  Boot ID:                       b43a9e80-d3b3-476f-8a7a-579d8c4e014d
  Kernel Version:                5.15.0-105-generic
  OS Image:                      Ubuntu 22.04.3 LTS
  Operating System:              linux
  Architecture:                  amd64
  Container Runtime Version:     containerd://1.7.2
  Kubelet Version:               v1.27.6
  Kube-Proxy Version:            v1.27.6
PodCIDR:                         10.244.3.0/24
PodCIDRs:                        10.244.3.0/24
Non-terminated Pods:             (28 in total)
  Namespace                      Name                                                         CPU Requests  CPU Limits  Memory Requests   Memory Limits     Age
  ---------                      ----                                                         ------------  ----------  ---------------   -------------     ---
  ibm-spectrum-scale-csi-driver  ibm-spectrum-scale-csi-provisioner-0                         0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  ibm-spectrum-scale-csi-driver  ibm-spectrum-scale-csi-q66pk                                 0 (0%)        0 (0%)      0 (0%)            0 (0%)            17d
  kube-flannel                   kube-flannel-ds-5bxvc                                        100m (0%)     0 (0%)      50Mi (0%)         0 (0%)            32d
  kube-system                    kube-multus-ds-2htx8                                         100m (0%)     100m (0%)   50Mi (0%)         50Mi (0%)         32d
  kube-system                    kube-proxy-t98nh                                             0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  kube-system                    nvidia-device-plugin-daemonset-t5nkd                         0 (0%)        0 (0%)      0 (0%)            0 (0%)            30d
  kube-system                    rdma-shared-dp-ds-5z7gn                                      0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  kubeflow                       mpi-operator-755f9688d9-d7b5s                                0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  kubeflow                       training-operator-6d6cf57954-m47bq                           100m (0%)     100m (0%)   20Mi (0%)         30Mi (0%)         32d
  kubesphere-controls-system     default-http-backend-5cc678bcbb-f69dl                        10m (0%)      10m (0%)    20Mi (0%)         20Mi (0%)         32d
  kubesphere-controls-system     kubectl-admin-684dfb956b-6df2x                               0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  kubesphere-logging-system      fluent-bit-j5zrb                                             10m (0%)      500m (0%)   25Mi (0%)         200Mi (0%)        32d
  kubesphere-logging-system      ks-events-ruler-5bbfd88bf8-zsvsb                             150m (0%)     600m (0%)   75Mi (0%)         525Mi (0%)        32d
  kubesphere-logging-system      kube-auditing-webhook-deploy-687f6754fc-qd65p                20m (0%)      200m (0%)   50Mi (0%)         500Mi (0%)        32d
  kubesphere-logging-system      logsidecar-injector-deploy-6f546b8df-5lgpn                   20m (0%)      200m (0%)   20Mi (0%)         200Mi (0%)        32d
  kubesphere-monitoring-system   alertmanager-main-0                                          120m (0%)     300m (0%)   80Mi (0%)         250Mi (0%)        32d
  kubesphere-monitoring-system   alertmanager-main-2                                          120m (0%)     300m (0%)   80Mi (0%)         250Mi (0%)        32d
  kubesphere-monitoring-system   gpu-dcgm-exporter-f2fcx                                      100m (0%)     200m (0%)   128Mi (0%)        300Mi (0%)        32d
  kubesphere-monitoring-system   kube-state-metrics-57cddb4d98-95n8n                          120m (0%)     3 (2%)      190Mi (0%)        8392Mi (0%)       32d
  kubesphere-monitoring-system   node-exporter-kq9fd                                          112m (0%)     2 (1%)      200Mi (0%)        600Mi (0%)        32d
  kubesphere-monitoring-system   notification-manager-deployment-d6b8647d6-nwxt4              5m (0%)       500m (0%)   20Mi (0%)         500Mi (0%)        32d
  kubesphere-monitoring-system   prometheus-k8s-1                                             300m (0%)     4100m (3%)  450Mi (0%)        16434Mi (0%)      32d
  kubesphere-monitoring-system   prometheus-operator-764d4f9cb9-j9wfs                         110m (0%)     1200m (0%)  120Mi (0%)        300Mi (0%)        32d
  kubesphere-system              ks-console-c97bff564-5wkzh                                   20m (0%)      1 (0%)      100Mi (0%)        1Gi (0%)          32d
  kubesphere-system              ks-installer-6dfb474c6d-5hk5d                                20m (0%)      1 (0%)      100Mi (0%)        1Gi (0%)          32d
  sft-test                       job-935c127c2ed0469ebce913a15e250ce6-pytorch-job-master-0    60 (46%)      60 (46%)    536870912k (24%)  536870912k (24%)  8h
  volcano-system                 volcano-controllers-7b5896-6lsn9                             0 (0%)        0 (0%)      0 (0%)            0 (0%)            32d
  volcano-system                 volcano-scheduler-564cc678c6-wrtl4                           0 (0%)        0 (0%)      0 (0%)            0 (0%)            31d
Allocated resources:
  (Total limits may be over 100 percent, i.e., overcommitted.)
  Resource                     Requests        Limits
  --------                     --------        ------
  cpu                          61537m (48%)    75310m (58%)
  memory                       513778Mi (24%)  542599Mi (26%)
  ephemeral-storage            0 (0%)          0 (0%)
  hugepages-1Gi                0 (0%)          0 (0%)
  hugepages-2Mi                0 (0%)          0 (0%)
  nvidia.com/gpu               8               8
  rdma/hca_shared_devices_ib1  0               0
  rdma/hca_shared_devices_ib2  0               0
  rdma/hca_shared_devices_ib3  0               0
  rdma/hca_shared_devices_ib4  0               0
  rdma/hca_shared_devices_ib5  0               0
  rdma/hca_shared_devices_ib6  0               0
  rdma/hca_shared_devices_ib7  0               0
  rdma/hca_shared_devices_ib8  0               0
Events:                        <none>

```
