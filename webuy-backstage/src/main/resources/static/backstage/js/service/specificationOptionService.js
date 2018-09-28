//服务层
app.service('specificationOptionService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../specificationOption/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../specificationOption/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../specificationOption/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../specificationOption/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../specificationOption/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../specificationOption/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../specificationOption/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
