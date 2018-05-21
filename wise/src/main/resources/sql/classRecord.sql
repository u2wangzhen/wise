##获取列表
#sql("list")
	select id   ,cid  ,record_data  ,start_time  ,end_time  ,class_hour  ,remark  ,del_flag 	from
    t_class_record 
#end

##分页
#sql("pageList")
	select id   ,cid  ,record_data  ,start_time  ,end_time  ,class_hour  ,remark  ,del_flag 	from
	t_class_record where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,cid  ,record_data  ,start_time  ,end_time  ,class_hour  ,remark  ,del_flag 	from
	t_class_record where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
	#if(date1!=null) and start_time > '#(date1)' and start_time < '#(date2)' #end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end