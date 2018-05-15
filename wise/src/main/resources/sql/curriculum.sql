##获取列表
#sql("list")
	select id   ,name  ,subject  ,type  ,grade  ,teacher_id  ,teacher_name  ,start_time  ,end_time  ,remark  ,del_flag 	from
    t_curriculum 
#end

##分页
#sql("pageList")
	select id   ,name  ,subject  ,type  ,grade  ,teacher_id  ,teacher_name  ,start_time  ,end_time  ,remark  ,del_flag 	from
	t_curriculum where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,name  ,subject  ,type  ,grade  ,teacher_id  ,teacher_name  ,start_time  ,end_time  ,remark  ,del_flag 	from
	t_curriculum where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end