##学生课时统计
#sql("student_CH")
SELECT ss.`name` as student_name,SUM(c.class_hour) as total from t_class_record c,t_curriculum_student s,t_student ss WHERE s.student_id=ss.id and c.cid=s.cid 

#if(start_time!="")and c.start_time > '#(start_time)' and c.start_time < '#(end_time)' #end


GROUP BY ss.`name`
#end
####
#sql("teacher_CH")
SELECT c.teacher_name,SUM(r.class_hour) as total from t_class_record r,t_curriculum c where c.id=r.cid 
#if(start_time!="") and r.start_time > '#(start_time)' and r.start_time < '#(end_time)' #end
GROUP BY c.teacher_name 
#end
####
#sql("curriculum_CH")
SELECT c.name,SUM(r.class_hour) as total from t_class_record r,t_curriculum c where c.id=r.cid 
#if(start_time!="") and r.start_time > '#(start_time)' and r.start_time < '#(end_time)' #end
GROUP BY c.name
#end

#sql("calendar_CH")
select record_data,count(*) as ks from t_class_record where 1=1  
#if(start_time!="") and start_time > '#(start_time)' and start_time < '#(end_time)'  #end
GROUP BY record_data
#end

##获取列表
#sql("list")
	select r.id ,r.cid  ,r.record_data  ,r.start_time  ,r.end_time  ,r.class_hour  ,r.remark  ,r.del_flag,c.name as cname from
    t_class_record r,t_curriculum c  where r.cid=c.id 
    #if(cid!=null&&cid!="") and  r.cid = '#(cid)' #end
   #if(start_time!=null&&start_time!="") and r.start_time > '#(start_time)' and r.start_time < '#(end_time)' #end
   #if(start1!=null&&start1!="")
    and (( r.start_time < '#(end1)' and r.start_time >= '#(start1)') or (r.end_time > '#(start1)' and r.end_time <= '#(end1)' ))
   #end
   
   order by r.start_time asc
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
	select r.id   ,c.name as cname  ,r.record_data  ,r.start_time  ,r.end_time  ,r.class_hour  ,r.remark  ,r.del_flag 	from
	t_class_record r,t_curriculum c where 1=1 and c.id=r.cid 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
	#if(date1!=null) and r.start_time > '#(date1)' and r.start_time < '#(date2)' #end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end