package com.example.SpringBatchCSV.writer;

import com.example.SpringBatchCSV.entity.User;
import com.example.SpringBatchCSV.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DBWriter implements ItemWriter<User> {

  @Autowired private UserRepository userRepository;

  private KafkaTemplate<String, Object> kafkaTemplate;

  public DBWriter(UserRepository userRepository, KafkaTemplate<String, Object> kafkaTemplate) {
    this.userRepository = userRepository;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void write(List<? extends User> users) throws Exception {

    log.info("[START] write users to database");
    log.info("begin sending  items to kafka ");

    kafkaTemplate.send("quickstart-events", "file has been treated");

    log.info("[END] write users to database");
  }

  /*@Bean
      public ItemWriter<User> kafkaItemWriter(){
          return list -> {
              log.info("begin sending  items to kafka ");
              list.forEach(item ->
              {
                  log.debug("begin send item to kafka", item.getName());

                  kafkaTemplate.send("quickstart-events", "file has been treated");
              }
          );

          };
      }*/



}
