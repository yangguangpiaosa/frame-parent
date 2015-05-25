-- Create table
create table EMPLOYEE
(
  emp_no     VARCHAR2(10) not null,
  emp_name   VARCHAR2(30),
  emp_salary NUMBER(6,2),
  hiredate   DATE
)
tablespace MIND
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column EMPLOYEE.emp_no
  is '员工编号';
comment on column EMPLOYEE.emp_name
  is '员工姓名';
comment on column EMPLOYEE.emp_salary
  is '员工薪水';
comment on column EMPLOYEE.hiredate
  is '聘用日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table EMPLOYEE
  add constraint P_EMP_NO primary key (EMP_NO)
  using index 
  tablespace MIND
  pctfree 10
  initrans 2
  maxtrans 255;
  

insert into EMPLOYEE (emp_no, emp_name, emp_salary, hiredate)
values ('2012061001', '王杰', 5000, to_date('07-06-2012', 'dd-mm-yyyy'));
insert into EMPLOYEE (emp_no, emp_name, emp_salary, hiredate)
values ('2012061002', '李红', 4800, to_date('08-06-2012', 'dd-mm-yyyy'));
commit;
