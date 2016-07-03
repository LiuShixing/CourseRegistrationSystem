function delect_pro(id) {
	 if(confirm("确定删除？"))
	  {
	   window.location.href='/CoRegSystem/servlet/DelectPro?id='+id;
	  }

}