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


```yaml
apiVersion: batch.volcano.sh/v1alpha1
kind: Job
metadata:
  creationTimestamp: '2024-06-21T01:29:40Z'
  generation: 1
  labels:
    athena-job-name: job-935c127c2ed0469ebce913a15e250ce6
    athena-task-type: sft
  managedFields:
  - apiVersion: batch.volcano.sh/v1alpha1
    fieldsType: FieldsV1
    fieldsV1:
      f:metadata:
        f:labels:
          .: {}
          f:athena-job-name: {}
          f:athena-task-type: {}
      f:spec:
        .: {}
        f:minAvailable: {}
        f:plugins:
          .: {}
          f:pytorch: {}
          f:svc: {}
        f:policies: {}
        f:priorityClassName: {}
        f:queue: {}
        f:schedulerName: {}
        f:tasks: {}
    manager: Kubernetes Java Client
    operation: Update
    time: '2024-06-21T01:29:40Z'
  name: job-935c127c2ed0469ebce913a15e250ce6
  namespace: sft-test
  resourceVersion: '11793222'
  uid: 9318c91c-3971-4ae1-b96a-b31ada01fc8f
spec:
  minAvailable: 2
  plugins:
    pytorch:
    - --master=pytorch-job-master
    - --worker=pytorch-job-worker
    - --port=14729
    svc:
    - publish-not-ready-addresses=disable
    - --disable-network-policy=disable
  policies:
  - action: TerminateJob
    events:
    - PodFailed
    - PodEvicted
    - Unknown
  priorityClassName: low-priority-nonpreempting
  queue: sft
  schedulerName: volcano
  tasks:
  - name: pytorch-job-master
    replicas: 1
    template:
      metadata:
        labels:
          athena-job-name: job-935c127c2ed0469ebce913a15e250ce6
          athena-task-type: sft
      spec:
        containers:
        - command:
          - /bin/bash
          - -c
          - |-
            echo "nameserver 10.96.0.10
            search sft-test.svc.cluster.local svc.cluster.local cluster.local" >  /etc/resolv.conf
            mkdir -p /var/run/sshd
            /usr/sbin/sshd
            source ~/.bashrc
            conda activate flash
            nvidia-smi
            bash /opt/code/LLM-Pruner/fastchat/fastchat_dp.sh /opt/input/model 2 2 2.0E-5 3 true false 6 'cosine' 0.1 1250 2048 true 200 100 10 '<|im_start|>' '<|im_end|>' 'qwen_7b' true '/opt/input/data/multi_train'
          env:
          - name: JOB_ID
            value: 935c127c2ed0469ebce913a15e250ce6
          image: harbor.test.hihonor.com/base-image/fastchat-deepspeed-lite:v2.1
          imagePullPolicy: Always
          name: pytorch-job-master-container-0
          resources:
            limits:
              cpu: '60'
              memory: 536870912k
              nvidia.com/gpu: '8'
          securityContext:
            capabilities:
              add:
              - IPC_LOCK
            privileged: true
          volumeMounts:
          - mountPath: /opt/share/code
            name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          - mountPath: /opt/code
            name: 935c127c2ed0469ebce913a15e250ce6-algo
          - mountPath: /opt/output
            name: 935c127c2ed0469ebce913a15e250ce6-output
          - mountPath: /opt/input/data/multi_train
            name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
            readOnly: true
          - mountPath: /opt/input/model
            name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          - mountPath: /dev/shm
            name: cache-volume
          workingDir: /opt/code
        dnsPolicy: ClusterFirstWithHostNet
        hostNetwork: true
        initContainers:
        - args:
          - -c
          - 'cp /opt/share/code/custimize_sft_test_06_V1_935c127c2ed0469ebce913a15e250ce6.tar.gz
            /opt/code  && tar -xvf /opt/code/custimize_sft_test_06_V1_935c127c2ed0469ebce913a15e250ce6.tar.gz
            --strip-components=1 -C /opt/code '
          command:
          - /bin/sh
          image: harbor.test.hihonor.com/library/ubuntu-init:18.04
          imagePullPolicy: Always
          name: athena-init-container
          resources:
            limits:
              cpu: 500m
              memory: 50Mi
            requests:
              cpu: 100m
              memory: 10Mi
          volumeMounts:
          - mountPath: /opt/share/code
            name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          - mountPath: /opt/code
            name: 935c127c2ed0469ebce913a15e250ce6-algo
          - mountPath: /opt/output
            name: 935c127c2ed0469ebce913a15e250ce6-output
          - mountPath: /opt/input/data/multi_train
            name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
            readOnly: true
          - mountPath: /opt/input/model
            name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          - mountPath: /dev/shm
            name: cache-volume
          workingDir: /opt/code
        nodeSelector:
          volcano.scheduler/queue: sft
        restartPolicy: Never
        terminationGracePeriodSeconds: 0
        volumes:
        - name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-share-algo
        - name: 935c127c2ed0469ebce913a15e250ce6-algo
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-algo
        - name: 935c127c2ed0469ebce913a15e250ce6-output
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-output
        - name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
          nfs:
            path: /finetune/datasets/bbb5c0faa8d60aee7e9001ec362b2123/multi_train
            readOnly: true
            server: 10.69.179.245
        - name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
        - emptyDir:
            medium: Memory
          name: cache-volume
  - name: pytorch-job-worker
    replicas: 1
    template:
      metadata:
        labels:
          athena-job-name: job-935c127c2ed0469ebce913a15e250ce6
          athena-task-type: sft
      spec:
        containers:
        - command:
          - /bin/bash
          - -c
          - |-
            echo "nameserver 10.96.0.10
            search sft-test.svc.cluster.local svc.cluster.local cluster.local" >  /etc/resolv.conf
            mkdir -p /var/run/sshd
            /usr/sbin/sshd
            source ~/.bashrc
            conda activate flash
            nvidia-smi
            bash /opt/code/LLM-Pruner/fastchat/fastchat_dp.sh /opt/input/model 2 2 2.0E-5 3 true false 6 'cosine' 0.1 1250 2048 true 200 100 10 '<|im_start|>' '<|im_end|>' 'qwen_7b' true '/opt/input/data/multi_train'
          env:
          - name: JOB_ID
            value: 935c127c2ed0469ebce913a15e250ce6
          image: harbor.test.hihonor.com/base-image/fastchat-deepspeed-lite:v2.1
          imagePullPolicy: Always
          name: pytorch-job-worker-container-1
          resources:
            limits:
              cpu: '60'
              memory: 536870912k
              nvidia.com/gpu: '8'
          securityContext:
            capabilities:
              add:
              - IPC_LOCK
            privileged: true
          volumeMounts:
          - mountPath: /opt/share/code
            name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          - mountPath: /opt/code
            name: 935c127c2ed0469ebce913a15e250ce6-algo
          - mountPath: /opt/output
            name: 935c127c2ed0469ebce913a15e250ce6-output
          - mountPath: /opt/input/data/multi_train
            name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
            readOnly: true
          - mountPath: /opt/input/model
            name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          - mountPath: /dev/shm
            name: cache-volume
          workingDir: /opt/code
        dnsPolicy: ClusterFirstWithHostNet
        hostNetwork: true
        initContainers:
        - args:
          - -c
          - 'cp /opt/share/code/custimize_sft_test_06_V1_935c127c2ed0469ebce913a15e250ce6.tar.gz
            /opt/code  && tar -xvf /opt/code/custimize_sft_test_06_V1_935c127c2ed0469ebce913a15e250ce6.tar.gz
            --strip-components=1 -C /opt/code '
          command:
          - /bin/sh
          image: harbor.test.hihonor.com/library/ubuntu-init:18.04
          imagePullPolicy: Always
          name: athena-init-container
          resources:
            limits:
              cpu: 500m
              memory: 50Mi
            requests:
              cpu: 100m
              memory: 10Mi
          volumeMounts:
          - mountPath: /opt/share/code
            name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          - mountPath: /opt/code
            name: 935c127c2ed0469ebce913a15e250ce6-algo
          - mountPath: /opt/output
            name: 935c127c2ed0469ebce913a15e250ce6-output
          - mountPath: /opt/input/data/multi_train
            name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
            readOnly: true
          - mountPath: /opt/input/model
            name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          - mountPath: /dev/shm
            name: cache-volume
          workingDir: /opt/code
        nodeSelector:
          volcano.scheduler/queue: sft
        restartPolicy: Never
        terminationGracePeriodSeconds: 0
        volumes:
        - name: 935c127c2ed0469ebce913a15e250ce6-share-algo
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-share-algo
        - name: 935c127c2ed0469ebce913a15e250ce6-algo
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-algo
        - name: 935c127c2ed0469ebce913a15e250ce6-output
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-output
        - name: 935c127c2ed0469ebce913a15e250ce6-sft-dataset-nas
          nfs:
            path: /finetune/datasets/bbb5c0faa8d60aee7e9001ec362b2123/multi_train
            readOnly: true
            server: 10.69.179.245
        - name: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
          persistentVolumeClaim:
            claimName: 935c127c2ed0469ebce913a15e250ce6-qwen-7b-20240516-v1
        - emptyDir:
            medium: Memory
          name: cache-volume
```

```python
import os
import argparse
import gradio as gr
from gradio.themes.utils import colors

from tab_entity_extraction import build_entity_extraction_tab
from tab_event_extraction import build_event_extraction_tab
from tab_screen_comprehension import build_screen_comprehension_tab
from tab_abstract_semantic_extraction import build_abstract_semantic_extraction_tab
from tab_picture_edit import build_picture_edit_tab
from tab_about_us import build_about_us_tab

# if __name__ == "__main__":


# 设置临时目录路径
os.environ['GRADIO_TEMP_DIR'] = '/mnt/nas/mm/ie_env/tmp'
parser = argparse.ArgumentParser()
parser.add_argument("--private", default=False, action='store_true')
parser.add_argument("--port", default=11300, type=int)
args = parser.parse_args()

theme=gr.themes.Soft(primary_hue=colors.gray, neutral_hue=colors.neutral)
js_func = """
function refresh() {
    const url = new URL(window.location);

    if (url.searchParams.get('__theme') !== 'dark') {
        url.searchParams.set('__theme', 'dark');
        window.location.href = url.href;
    }
}
"""
with gr.Blocks(theme=theme,js=js_func) as demo:
    gr.Markdown("""荣耀智慧大模型demo平台""")
    with gr.Tabs(elem_classes="tab-buttons") as tabs:
        with gr.TabItem("实体提取", elem_id="chat", id=1):
            build_entity_extraction_tab()

        with gr.TabItem("事件提取", elem_id="chat", id=2):
            build_event_extraction_tab()
        
        with gr.TabItem("屏幕理解", elem_id="info", id=3):
            build_screen_comprehension_tab()

        with gr.TabItem("抽象语义提取", elem_id="info", id=4):
            build_abstract_semantic_extraction_tab()

        with gr.TabItem("指令图像编辑", elem_id="info", id=5):
            build_picture_edit_tab()

        with gr.TabItem("About Us", elem_id="info", id=0):
            build_about_us_tab()

if args.private:
    demo.queue().launch(share=False, server_name="127.0.0.1", server_port=args.port, max_threads=1)
else:
    demo.queue().launch(share=True, server_name="0.0.0.0", server_port=args.port, max_threads=1)





def build_entity_extraction_tab():
    with gr.Row():
        with gr.Column(scale=3):
            imagebox = gr.Image(
                type='filepath', 
                interactive=True,
                sources=["upload", "clipboard"]
            )
            with gr.Accordion("level 1", open=False ,visible=True):
                gr.Examples(
                    examples=[
                        ['examples/entity_extraction/level_1_event_1.jpg'],
                        ['examples/entity_extraction/level_1_event_3.jpg'],
                        ['examples/entity_extraction/level_1_post_2.jpg'],
                    ],
                inputs=[imagebox],
                outputs=[imagebox],
                cache_examples=False)

            with gr.Accordion("level 2", open=False ,visible=True):
                gr.Examples(
                    examples=[
                        ['examples/entity_extraction/level_2_event_1.jpg'],
                        ['examples/entity_extraction/level_2_post_1.jpg'],
                        ['examples/entity_extraction/level_2_post_2.jpg'],
                    ],
                inputs=[imagebox],
                outputs=[imagebox],
                cache_examples=False)
    
            with gr.Accordion("level 3", open=False ,visible=True):
                gr.Examples(
                    examples=[
                        ['examples/entity_extraction/level_3_post_3.jpg'],
                        ['examples/entity_extraction/level_3_post_1.jpg'],
                        ['examples/entity_extraction/level_3_post_2.jpg'],
                    ],
                inputs=[imagebox],
                outputs=[imagebox],
                cache_examples=False)
            chat_max_output_tokens, chat_num_beams, \
                chat_repetition_penalty, chat_do_sample = build_control_panel()

        with gr.Column(scale=9):
            chat_states = [gr.State([]) for _ in range(num_chatbots)]
            model_selectors = [None] * num_chatbots
            chatbots = [None] * num_chatbots
            json_viewers = [None] * num_chatbots

            with gr.Row():    
                for i in range(num_chatbots):
                    with gr.Column(scale=3):
                        chat_states[i] = gr.State()
                        model_selectors[i], chatbots[i], json_viewers[i] = build_single_chatbot(i)

            with gr.Row():
                with gr.Column(scale=8):
                    chat_textbox = gr.Textbox(
                        value="请从当前输入的图片中进行实体提取，注意不同title的图片关注返回的实体类型不一样，请注意区分。不得返回每种title图片关注之外的实体。结果以List存储一个或多个map的方式进行返回。",
                        lines=5,
                        show_label=False,
                        visible=True)

                with gr.Column(scale=2, min_width=100):
                    submit_btn = gr.Button(value="Submit", variant="primary",
                                        visible=True)
                    regenerate_btn = gr.Button(value="🔄 Regenerate",
                                            interactive=True)
                    
                    clear_btn = gr.Button(value="🗑️  Clear history",
                                        interactive=False)
        def change_textbox(text):
            prompts = [
                    "请从当前输入的图片中进行实体提取，注意不同title的图片关注返回的实体类型不一样，请注意区分。不得返回每种title图片关注之外的实体。结果以List存储一个或多个map的方式进行返回。",
                    "请从当前输入的图片中提取作品名，时间，地址3种实体并存储到字典中，针对没有出现的实体，请用''进行值的替换。每种实体如涉及多个实体值，实体值用列表罗列，结果以json形式输出",
                    # "请从当前输入的图片中提取实体，结果以List存储一个或多个map的方式进行返回。"
                ]
            for i in prompts:
                if i != text:
                    return gr.Textbox(
                        value=i,
                        lines=5,
                        show_label=False,
                        visible=True)

        regenerate_btn.click(change_textbox, chat_textbox, chat_textbox)
        parameter_list = [
                chat_max_output_tokens, chat_repetition_penalty,
                chat_num_beams, chat_do_sample
            ]

        submit_btn.click(
            add_text,
            [chat_textbox] + model_selectors,
            chatbots + [chat_textbox]
        ).then(
            predict, 
            model_selectors + chatbots + [imagebox],
            chatbots + json_viewers)

    with gr.Row():
        gr.Markdown(
        """
            ### Model Author: 杨  赫(00031743)
            ### Demo Author: 黄逸嘉(00031952)、张晟辉(00032043)
        """)
---------------------------------------------------------------------------------------------------------------------


Introduction.
😄 Today I'm gonna recommend some awesome vscode extensions that will improve your productivity.
I will show you the must-have extensions for beginners. so you will see which extensions I'm using. If you are ready, let's get started. 
🤔 Before we start writting a single line of code, we first need to install a special tool, called a code editor. And a code editor is essentially a special software that allows us to write programming code like javascript, HTML and CSS in a very easy way. so now in this video, I will guide you through installing the very best code editor in the world. And I will also show you how to set it up a little bit with some special settings, color themes and extensions.
The code editor that we're going to use is called visual/ˈvɪʒuəl/ studio/ˈstuːdioʊ/ code from Microsoft/ˈmaɪkrəsɔːft/ And this is the very best code editor for web development in the world. So actually every developer that I know right now uses this code editor/ˈedɪtər/.
So to download it, just go to code.visualstudio.com or to make it even easier, you can just Google vscode. And it should be this very first one. And of course, vscode is available for free and for all platforms out there. And so please just go head right now and download the installer for your own system.
After managed to install vscode. once you open up the code editor, it should look something like this. And we will start by installing an extension. And an extension for vscode is basically just a small piece of functionality that we can download and which makes the editor a little bit better. So we can basically customize the editor to our needs. So you can think of it a little bit like Google Chrome/kroʊm/ extensions. so it's the same concept. 

Prettier.  /ˈprɪtiər/
😉  The first one we're going to install for now is called prettier. So just search for prettier. And then it's probably going to be this first result here. because prettier is an extremely popular extension. You see it has over 12 million downloads right now. And just go ahead and click install here and then enable it. And probably you will have to also reload this vscode window. Now what this extension does is to automatically format your code whenever you save it. So now let's come down here to this settings icon, then choose settings from here so that we can now tweak/twiːk/ a couple of settings. And let's actually start with two settings that are related to the prettier extension we just installed. So just come here to the search bar. So searching for the setting name is actually the easiest way of finding them. So just type here, default formatter. And so here, we actually need to set it to prettier. I already have it set, of course, but you will have to go through this list and find prettier somewhere here. choose prettier code formatter.
finishing installed prettier
👏  Okay, And so now vscode knows that it should use that prettier extension we just installed to format your code. Now, when should it actually format your code?  Well, we need to set another set thing for that, which is the format on safe setting. So it's this on here, you need to check this checkbox so that prettier will automatically format your file each time that you save it.
👏  Okay, another one that is very important is the auto safe setting. So auto safe, we need to set it to onFocusChange. And what this will do is to automatically save your files as you go to another tab or as you leave the window completely.
👏  And so this is very important so that you never lose your edits and you don't have to manually save your files all the time.
finishing format save and auto save

One monakai.
👉 And now, let's talk about colors. So basically we can customize /ˈkʌstəmaɪz/ vscode with a color theme, which will then change the colors of the code editor itself and also of the code. So it will basically highlight different parts of the code with different colors. Now, this is just a thing of personal preference /ˈprefrəns/. 
👉 So you can just use the theme that already comes automatically by default with vscode. But I choose to install a special theme that I believe makes it very easy to read the code. So a color theme is basically just another extension that we need to install. And this one is called One Monokai.
👉 So this very first one here, and as you can see down here, it will give our code these kinds of colors, and also the vscode editor itself will have this blue color that you can see already here in this window. you can set the color theme using this option here.
👉  And you can also experiment /ɪkˈsperɪmənt/ with some other themes, of course, down here, again, in the settings icon. And then here in color theme, you can choose one of these light themes or one of these dark themes.
👉 So vscode already comes with a bunch of /ə bʌntʃ əv/ themes pre-installed basically. And so you can try them out as well. Or if you have another preference, you can also install any other theme that you would like.
finishing one monakai

Image preview.
🗾 And the next extension that I want to introduce is called, Image preview. So it's this one and I already have it installed. So I just need to click on enable. Okay. So that's the first one. And what this one is going to do is that here in our HTML, it now displays this small image preview here in this gutter as it's called. So here we have this one and then this image here is also right here where we declare it. So where we include it in our code, and this can be extremely helpful sometimes. So that's why I really wanted to show you this one.

Color highlight.
🎨 The next one that I want to show you is called color highlight. So it's this one here and again, I already have it installed. I just enable it. And actually this one, I cannot show you yet what it looks like, because it will only be relevant in CSS. But trust me that this extension is really, really helpful for visualizing colors in CSS.

Auto rename tag. 
🔖  Next up is an extension called auto rename tag. So this one, and you see it's an extremely popular one, once again. So you have to download it and enable it. And then what happens here is that, when we changed the name of an element, let's say we actually wanted to make this one a div, then you see it automatically also changes the closing one. So the closing tag.
👉 Okay. And this again is extremely helpful it makes our life writing HTML a bit easier, because trust me, we need to do this all the time, like changing the element name.
👉 Okay. Now another thing that we need to do, or at least that we can do if we want, is to go back to our settings and then turn back on this setting that we deactivated at the beginning of the section. So that's the auto close tag. So let's enable this back because I think at this point you will no longer make the mistake of forgetting a closing tag. And so now we can allow vscode to do that work for us. So for example, if we wanted to write a paragraph/ˈpærəɡræf/ here. Then now you see HTML automatically close that element for us.

Live server.
💡 Okay. and now, we are going to install the most important and the most useful one of all, and that is called live server. So it's this one here, live server with almost 12 million downloads and this one is popular for a reason. So, I just click enable here and, so when I go now to my HTML and let's close this one down. So close down the sidebar. Now down here in this bar, we should have now this go live button.
✊🏽 Okay. So hopefully after installing this live server extension, you can also see this button down here in this status bar. So when I now click this, then it starting and we get this message that server is started at this port number here. Let's close that. And you see it, that it opened a new tab, which contains our page, right? So basically it looks exactly the same, but there is one very big difference.
✊🏽 So, let's say we wanted to change this here. I'm going to call it JONAS CODE. And now, look closely what happens here as I save this file. So I hit command S now, or control S on windows. And you see what happened. It automatically reloaded the page without us having to do anything. So all we did was save to code and what will then happen is that this page here gets automatically updated. So all the changes that we did here will basically get injected into this page. And, now, we can then see the reflection of our changes immediately.
👍 So I put it back now. I hit again, command or control S to save it and immediately you see it going back to what it was before. Now if we wanted to stop this connection, once we are done developing, all we have to do is to click down here on this icon here where it says port 5500.
👏 And by the way, this port number is exactly what we have here. Okay. So just for the sake of curiosity, this one here means that it's a local host server. So basically it's like you have now a web server on your own computer running. And then we have actually this code running at this port number. And so this port, it's basically like a sub address of your web server. So of the local local host server, but this doesn't really matter.
🤞 What matters is that this now works and it is really, really helpful for our development workflow. Now, if for some reason you could not make this work on your computer, then of course don't worry. So you can still do it the old way. So basically the way we have been doing it all along, up until this point. So you can just open up the file from your file system like we did, and then keep refreshing it manually.
🙌 Right. But we, right now, no longer need this tab here because we now have our live connection. So we have our live server serving up this page whenever we do some edits.

All right. And with that we are now ready to tackle or final less two coding challenges in this HTML fundamental section.


eslint materials icon theme

```
