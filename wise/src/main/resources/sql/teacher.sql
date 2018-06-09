##获取列表
#sql("list")
	select id   ,name  ,phone  ,sex  ,class_type  ,remark  ,create_time  ,del_flag 	from
    t_teacher where 1=1 
	#if(class_type!=null&&class_type!="") and  class_type like '%#(class_type)%' #end
	#if(name2!=null&&name2!="") and name ='#(name2)' #end
#end

##分页
#sql("pageList")
	select id   ,name  ,phone  ,sex  ,class_type  ,remark  ,create_time  ,del_flag 	from
	t_teacher where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,name  ,phone  ,sex  ,class_type  ,remark  ,create_time  ,del_flag 	from
	t_teacher where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) '%#(x.value)%'
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end