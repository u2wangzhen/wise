###利润
select c.`name`,CAST( (SUM(r.class_hour)*m.student_count*m.class_fee)-(SUM(r.class_hour)*m.teacher_price) AS  DECIMAL(8,2)) as total  from t_class_record r ,t_curriculum_config m,t_curriculum c where c.id=r.cid and m.cid=c.id GROUP BY c.name
###学生
select c.`name`,CAST( SUM(r.class_hour)*m.student_count*m.class_fee AS  DECIMAL(8,2)) as total  from t_class_record r ,t_curriculum_config m,t_curriculum c where c.id=r.cid and m.cid=c.id GROUP BY c.name
###老师
select c.`name`,CAST( (SUM(r.class_hour)*m.teacher_price) AS  DECIMAL(8,2)) as total  from t_class_record r ,t_curriculum_config m,t_curriculum c where c.id=r.cid and m.cid=c.id GROUP BY c.name