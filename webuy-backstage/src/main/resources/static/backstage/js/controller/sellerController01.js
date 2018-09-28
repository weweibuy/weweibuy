 //控制层 
app.controller('sellerController01' ,function($scope,$controller   ,sellerService01){
	
	$controller('baseController',{$scope:$scope});//继承

    $scope.searchEntity={};//定义搜索对象

    //搜索
    $scope.search=function(page,rows){
        sellerService01.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.data.rows;
                $scope.paginationConf.totalItems=response.data.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        sellerService01.findOne(id).success(
            function(response){
                $scope.entity= response.data;
            }
        );
    }

    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        sellerService01.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //分页
    $scope.findPage=function(page,rows){
        sellerService01.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }


    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=sellerService01.update( $scope.entity ); //修改
        }else{
            serviceObject=sellerService01.add( $scope.entity  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }


    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        sellerService01.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    }



    //更改状态
    $scope.updateStatus=function(sellerId,status){
        sellerService01.updateStatus(sellerId,status).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }
    
});	
