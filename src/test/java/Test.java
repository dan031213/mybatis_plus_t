import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dan.dao.EmpDao;
import com.dan.entity.Emp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {


    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


    @org.junit.Test
    public void queryAll() {
        EmpDao empDao = context.getBean(EmpDao.class);
        System.out.println(empDao);
        List list = empDao.selectList(null);
        System.out.println(list);
//        list.forEach(System.out::print);
    }

    @org.junit.Test
    public void queryPart() {
        EmpDao empDao = context.getBean(EmpDao.class);
        System.out.println(empDao);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.between("empno", 4, 7);
        List list = empDao.selectList(queryWrapper);
        System.out.println(list);
//        list.forEach(System.out::print);
    }

    @org.junit.Test
    public void insertOne() {
        EmpDao empDao = context.getBean(EmpDao.class);
        Emp emp = new Emp();
        emp.setDepno(12);
        emp.setEname("dabomei");
        emp.setComm(3003.33);
        emp.setHiredate(new Date());
        int insert = empDao.insert(emp);
        System.out.println(insert);
    }

    @org.junit.Test
    public void delete() {
        EmpDao empDao = context.getBean(EmpDao.class);
        int insert = empDao.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(insert);
    }

    @org.junit.Test
    public void delete2() {
        EmpDao empDao = context.getBean(EmpDao.class);
        int insert = empDao.deleteById(1);
        System.out.println(insert);
    }

    @org.junit.Test
    public void update() {
        EmpDao empDao = context.getBean(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(7);
        emp.setEname("shaoyujuan");
        emp.setHiredate(new Date());
        int insert = empDao.updateById(emp);
        System.out.println(insert);
    }

}
