//服务层
app.service('sellerService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../seller/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../seller/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../seller/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../seller/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../seller/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../seller/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../seller/search?page='+page+"&rows="+rows, searchEntity);
	}    
	
	this.updateStatus = function(sellerId,status){
		return $http.get('../seller/updateStatus?sellerId='+sellerId+"&status="+status);
	}
});
