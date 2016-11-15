#taotao.com

#淘淘商城测试环境Host
192.168.20.101 www.taotao.com#9092
192.168.20.101 taotao.com#9092
192.168.20.101 rest.taotao.com#9091
192.168.20.101 search.taotao.com#9093
192.168.20.101 sso.taotao.com#9094
192.168.20.101 order.taotao.com#9095
192.168.20.101 manager.taotao.com#9090

#启动服务
startall.sh

#search 服务 import all item
http://search.taotao.com/search/manager/importall

#deploy
tomcat7:redeploy

#测试
tomcat7:run


测试
