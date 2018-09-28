// 定义服务层:
app.service("brandService",function($http){
	this.findAll = function(){
		return $http.get("../brand/findAll");
	}
	
	this.findByPage = function(page,rows){
		return $http.get("../brand/findByPage?page="+page+"&rows="+rows);
	}
	
	this.save = function(entity){
		return $http.post("../brand/add",entity);
	}
	
	this.update=function(entity){
		return $http.post("../brand/update",entity);
	}
	
	this.findById=function(id){
		return $http.get("../brand/findOne?id="+id);
	}
	
	this.dele = function(ids){
		return $http.get("../brand/delete?ids="+ids);
	}
	
	this.search = function(page,rows,searchEntity){
		return $http.post("../brand/search?page="+page+"&rows="+rows,searchEntity);
	}
	
	this.selectOptionList = function(){
		return $http.get("../brand/selectOptionList");
	}
});