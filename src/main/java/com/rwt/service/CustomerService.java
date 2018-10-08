package com.rwt.service;

import com.rwt.entity.Customer;
import com.rwt.helper.DataBaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CustomerService {
    private  static final Logger logger=LoggerFactory.getLogger(CustomerService.class);
    /*
    获取客户列表
    */
    public List<Customer> getCustomerList(){
        //Connection connection=DataBaseHelper.getConnection();
        String SQL="select * from customer";
        /*List<Customer> list=new ArrayList<Customer>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("contact"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                list.add(customer);
            }
        }catch (SQLException e) {
            logger.error("execute sql failure",e);
        }*/




        return DataBaseHelper.queryList(Customer.class,SQL);
    }
    /*
    根据keyword获取客户列表
    */
    public List<Customer> getCustomerList(String keyword){
        return null;
    }
    /*
    获取客户
    */
    public Customer getCustomer(long id){
        String SQL="select * from customer where id="+id;
        return DataBaseHelper.queryObject(Customer.class,SQL);
    }
    /*
    创建客户
    */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return false;
    }
    /*
    更新客户
    */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
           return  false;
    }
    /*
    删除客户
    */
    public boolean deleteCustomer(long id){
        return false;
    }
}
