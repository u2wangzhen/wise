##获取列表
#sql("list")
	select id   ,cid  ,student_id 	from
    t_curriculum_student where 1=1 
	#if(cid!=null&&cid!="") and  cid = '#(cid)' #end
	#if(student_id!=null&&student_id!="") and  student_id = '#(student_id)' #end
#end

##分页
#sql("pageList")
	select id   ,cid  ,student_id 	from
	t_curriculum_student where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,cid  ,student_id 	from
	t_curriculum_student where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end