##获取列表
#sql("list")
	select id   ,student_id  ,amount  ,pay_date  ,remark  ,del_flag 	from
    t_student_payment 
#end

##分页
#sql("pageList")
	select id   ,student_id  ,amount  ,pay_date  ,remark  ,del_flag 	from
	t_student_payment where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,student_id  ,amount  ,pay_date  ,remark  ,del_flag 	from
	t_student_payment where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end