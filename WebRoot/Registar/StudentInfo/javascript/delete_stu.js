function delete_stu(id) {
	 if(confirm("确定删除？"))
	  {
	   window.location.href='/CoRegSystem/servlet/DeleteStu?id='+id;
	   
	  }

}