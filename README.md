# weweibuy
Springboot和SpringCloud的样例工程;使用SpringbootAdmin管理微服务,集成xxl-job分布式任务调度中心;Oauth2+zuul做服务的鉴权与转发
目录结构:  
├─weweibuy  
│  ├─webuy-admin  -------------------Spring-Boot-Admin微服务管理中心----100%  
│  ├─webuy-auth   -------------------Oauth2 认证授权中心 ---- 80%  
│  │  ├─webuy-auth-core  
│  │  └─webuy-auth-service  
│  ├─webuy-backstage  
│  ├─webuy-common  
│  ├─webuy-eureka   -----------------注册中心  --- 100%  
│  ├─webuy-gateway  -----------------zuul网关代理Oauth2中的资源服务器 认证授权中心 --- 80%   
│  ├─webuy-inventory  
│  ├─webuy-message  -----------------RabbitMq结合xxl-job基于可靠消息确保服务间数据一致性(待开发)  
│  ├─webuy-order  
│  ├─webuy-pay  
│  ├─webuy-product  
│  ├─webuy-search  
│  ├─webuy-support  
│  │  ├─webuy-support-client  
│  │  ├─webuy-support-common  
│  │  └─webuy-support-service  
│  ├─webuy-task   -----------------Springboot集成xxl-job ---- 100%  
│  └─webuy-user  
│      ├─webuy-user-client  
│      ├─webuy-user-common  
│      └─webuy-user-service  
