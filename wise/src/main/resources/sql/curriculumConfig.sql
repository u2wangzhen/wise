##获取列表
#sql("list")
	select id   ,cid  ,student_count  ,class_fee  ,teacher_price 	from
    t_curriculum_config where 1=1
    #if(cid!=null && cid!="") and cid = '#(cid)' #end
#end

##分页
#sql("pageList")
	select id   ,cid  ,student_count  ,class_fee  ,teacher_price 	from
	t_curriculum_config where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,cid  ,student_count  ,class_fee  ,teacher_price 	from
	t_curriculum_config where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end