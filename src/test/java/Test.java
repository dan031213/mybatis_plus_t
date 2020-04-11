import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dan.dao.EmpDao;
import com.dan.dao.UserDao;
import com.dan.entity.Emp;
import com.dan.entity.User;
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
    public void queryByPages() {
        EmpDao empDao = context.getBean(EmpDao.class);
        System.out.println(empDao);
//        List list = empDao.selectList(null);
        Page<Emp> empPage = empDao.selectPage(new Page<Emp>(1, 2), null);
        System.out.println(empPage.getRecords());
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
        int insert = empDao.deleteBatchIds(Arrays.asList(3, 4, 5));
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

    @org.junit.Test
    public void insertUserGenId() {
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        User user = new User();
        user.setUserName("lisi");
        user.setUserPassword("123456");
        user.setUserEmail("lizhenyang@casisd.cn");
        user.setUserAddress("南四街四号");
        int insert = userDao.insert(user);
        System.out.println(insert);
    }

    @org.junit.Test
    public void UpdateUser() {
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        User user = new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123456");
        user.setUserEmail("lizhenyang@casisd.cn3");
        user.setUserAddress("南四街四号3");
        UpdateWrapper<User> objectUpdateWrapper = new UpdateWrapper<User>();
        objectUpdateWrapper.eq("user_name", user.getUserName());
        objectUpdateWrapper.eq("user_password", user.getUserPassword());
        int update = userDao.update(user, objectUpdateWrapper);
        System.out.println(update);
    }

    /**
     * version控制版本，乐观锁 setVersion 无效
     */
    @org.junit.Test
    public void UpdateUserByVersion() {
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("user_name", "zhangsan");
        User user = userDao.selectOne(userQueryWrapper);
        System.out.println("user.getVersion()-->" + user.getVersion());
        user.setUserTel("15010987196");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//        }
        user.setVersion(8);
        int update = userDao.update(user, null);
        System.out.println(update);
        System.out.println("-----------------------");
        System.out.println(userDao.selectOne(userQueryWrapper));
    }

    @org.junit.Test
    public void selectUser() {
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("user_name", "zhangsan");
        User user = userDao.selectOne(userQueryWrapper);
        System.out.println(user);
    }


}
