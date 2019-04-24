#!/usr/bin/env bash

work_path=$(dirname $(readlink -f $0))
echo "脚本路径：$work_path"

#sudo rm -rf /opt/micro/ELK/
sudo mkdir -p /opt/micro/ELK/
sudo mkdir -p /opt/micro/ELK/log
sudo chown -R $USER /opt/micro
sudo ln -s $work_path/ELK/config /opt/micro/ELK/config

