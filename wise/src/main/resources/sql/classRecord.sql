##学生课时统计
#sql("student_CH")
SELECT ss.`name` as student_name,SUM(c.class_hour) as total from t_class_record c,t_curriculum_student s,t_student ss WHERE s.student_id=ss.id and c.cid=s.cid 

#if(start_time!="")and c.start_time > '#(strat_time)' and c.start_time < '#(end_time)' #end

GROUP BY ss.`name`
#end
####
#sql("teacher_CH")
SELECT c.teacher_name,SUM(r.class_hour) as total from t_class_record r,t_curriculum c where c.id=r.cid 
#if(start_time!="") and r.start_time > '#(strat_time)' and r.start_time < '#(end_time)' #end
GROUP BY c.teacher_name 
#end


##获取列表
#sql("list")
	select id   ,cid  ,record_data  ,start_time  ,end_time  ,class_hour  ,remark  ,del_flag 	from
    t_class_record where 1=1 
    #if(cid!=null&&cid!="") and  cid = '#(cid)' #end
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