package com.weweibuy.webuy.learning.spring.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import graphql.Scalars;
import graphql.schema.*;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author durenhao
 * @date 2021/3/11 16:30
 **/
@Slf4j
public class GraphqlTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() {

        String schema = "type Query{hello: String}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();

        ExecutionResult executionResult = build.execute("{hello}");

        System.err.println(executionResult.getData().toString());
    }


    public void test02() {
        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("User")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("sex").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("intro").type(Scalars.GraphQLString))
                .build();
    }

    @Test
    public void test03() throws Exception {

        CPU cpu = new CPU();
        cpu.setName("I7");
        cpu.setCache("19M");

        Memory m1 = new Memory();
        m1.setName("海盗船");
        m1.setSize("8G");

        Memory m2 = new Memory();
        m2.setName("海盗船");
        m2.setSize("8G");

        List<Memory> memoryList = new ArrayList<Memory>();
        memoryList.add(m1);
        memoryList.add(m2);

        Computer computer = new Computer();
        computer.setName("组装机");
        computer.setCpu(cpu);
        computer.setMemoryList(memoryList);
        BeanMap beanMap = BeanMap.create(computer);

        // 定义GraphQL类型
        GraphQLObjectType cpuType = GraphQLObjectType.newObject().name("cpuType")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("cache").type(Scalars.GraphQLString)).build();

        GraphQLObjectType memoryType = GraphQLObjectType.newObject().name("memoryType")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("size").type(Scalars.GraphQLString)).build();

        GraphQLObjectType computerType = GraphQLObjectType.newObject().name("computerType")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("cpu").type(cpuType))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("memoryList").type(new GraphQLList(memoryType))).build();


        // 关联返回类型与返回数据
        GraphQLObjectType queryType = GraphQLObjectType.newObject().name("computerQuery")
                .field(GraphQLFieldDefinition.newFieldDefinition().type(computerType).name("computer").dataFetcher(evn -> beanMap))
                .build();


        GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();

        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        Map<String, Object> result = graphQL.execute("{computer{name,cpu{name,cache},memoryList{n:name,size}}}")
                .getData();

        // 打印返回结果
        log.error(objectMapper.writeValueAsString(result));

    }

    @Test
    public void test04() throws Exception {


        CPU cpu = new CPU();
        cpu.setName("I7");
        cpu.setCache("19M");

        Memory m1 = new Memory();
        m1.setName("海盗船");
        m1.setSize("8G");

        Memory m2 = new Memory();
        m2.setName("海盗船");
        m2.setSize("8G");

        List<Memory> memoryList = new ArrayList<Memory>();
        memoryList.add(m1);
        memoryList.add(m2);

        Computer computer = new Computer();
        computer.setName("组装机");
        computer.setCpu(cpu);
        computer.setMemoryList(memoryList);
        BeanMap beanMap = BeanMap.create(computer);

        String schema =  "type Query{\n" +
                "\tcomputer: Computer\n" +
                "}\n" +
                "\n" +
                "type Computer  \t{\n" +
                "\tname: String  \n" +
                "\tcpu: CPU  \n" +
                "\tmemoryList: [Memory]\n" +
                "}\n" +
                "\n" +
                "type CPU {\n" +
                "\tname: String \n" +
                "\tcache: String\n" +
                "} \n" +
                "type Memory {\n" +
                "\tname: String\n" +
                "\tsize:String\n" +
                "}";


        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("computer", evn -> beanMap))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();


        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();

//        ExecutionResult executionResult = build.execute("{computer{name,cpu{name,cache},memoryList{n:name,size}}}");
        ExecutionResult executionResult = build.execute("{memoryList{n:name,size}}");

        List<GraphQLError> errors = executionResult.getErrors();
        if (CollectionUtils.isNotEmpty(errors)) {
            System.err.println(errors);
        } else {
            System.err.println(executionResult.getData().toString());
        }


    }


    @Data
    public static class CPU {
        private String name;
        private String cache;

    }

    @Data
    public static class Memory {
        private String name;
        private String size;
    }

    @Data
    public class Computer {
        private String name;
        private CPU cpu;
        private List<Memory> memoryList;
    }

}
