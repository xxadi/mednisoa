package com.medsys.nis.test; /**
 * Created by Super on 2020/8/1.
 */

import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/1 15:23
 */
public class ActivitiTest {
    /**
     * 会默认按照Resources目录下的activiti.cfg.xml创建流程引擎
     */
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void test() { //以下两种方式选择一种创建引擎方式：1.配置写在程序里 2.读对应的配置文件
        //1
        testCreateProcessEngine();
        //2
        testCreateProcessEngineByCfgXml();
        deployProcess();
        startProcess();
        queryTask();
//handleTask();
    }

    /**
     * 测试activiti环境
     */
    @Test
    public void testCreateProcessEngine() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        cfg.setJdbcDriver("com.mysql.jdbc.Driver");
        cfg.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti");
        cfg.setJdbcUsername("root");
        cfg.setJdbcPassword("root"); //配置建表策略
        cfg.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine engine = cfg.buildProcessEngine();
    }

    /**
     * 根据配置文件activiti.cfg.xml创建ProcessEngine
     */
    @Test
    public void testCreateProcessEngineByCfgXml() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine engine = cfg.buildProcessEngine();
    }

    /**
     * 发布流程
     * RepositoryService
     */
    @Test
    public void deployProcess() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("helloActiviti.bpmn");
        builder.deploy();
    }

    /**
     * 启动流程
     * <p>
     * RuntimeService
     */
    @Test
    public void startProcess() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
//可根据id、key、message启动流程
        runtimeService.startProcessInstanceByKey("myProcess_1");
    }

    /**
     * 查看任务
     * TaskService
     */
    @Test
    public void queryTask() {
        System.out.println("进来了");
        TaskService taskService = processEngine.getTaskService(); //根据assignee(代理人)查询任务
        String assignee = "张强";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);
        }
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() + ",taskName:" + task.getName() + ",assignee:" + task.getAssignee() + ",createTime:" + task.getCreateTime());
        }
        System.out.println("出去了");
    }

    /**
     * 办理任务
     */
    @Test
    public void handleTask() {
        TaskService taskService = processEngine.getTaskService(); //根据上一步生成的taskId执行任务
        String taskId = "2504";
        taskService.complete(taskId);
    }

}
