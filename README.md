



# docker

## 安装docker (ubuntu)
### 官网
`https://docs.docker.com/install/linux/docker-ce/ubuntu/`
### 卸载旧版本
`sudo apt-get remove docker docker-engine docker.io containerd runc`

`sudo apt-get update`

### 允许使用https安装repository
`sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common`

### add GPG key
`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`

### 安装repository
`sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" `

`sudo apt-get update`

### 安装docker,记得重启一下
`sudo apt-get install docker-ce docker-ce-cli containerd.io`

-------

## docker使用
### build and package

`mvn clean package`

### 建一个名字叫micro的网络

`sudo docker network inspect micro`

### 启动eureka 
`sudo docker run -d --name eureka --net micro -p 9000:8761 sunbo/eureka-server:0.0.1-SNAPSHOT`

### 启动服务provider
`sudo docker run -d --name provider --net micro -p 9001:8080 sunbo/sample-provider:0.0.1-SNAPSHOT`

### 访问eureka

`http://locahost:9000`


---

## docker-compose
 
### 安装 
#### 官网

 https://docs.docker.com/compose/install/
 
#### 安装命令

`sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x /usr/local/bin/docker-compose && docker-compose --version`

#### 安装命令行提示 

`https://docs.docker.com/compose/completion/`

#### 运行 (后台运行加 -d)
`cd docker-compose && docker-compose up --scale provider=2`
#### 访问eureka
`http://locahost:9000`

#### 运行eureka-ha (后台运行加 -d)
`cd docker-compose && docker-compose -f ./docker-compose-ha.yml up --scale provider=2`
#### 访问eureka
`http://locahost:9001`
`http://locahost:9002`

### 问题
跨主机网络如何实现？

#### 使用脚本控制各服务数量
`mvn clean package -Dmaven.test.skip=true`

`docker-compose -f docker-compose/docker-compose-ha.yml up`

`docker-compose -f docker-compose/docker-compose-ha.yml up --scale provider=4`
