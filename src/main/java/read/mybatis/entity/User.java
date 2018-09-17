package read.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by JAVA on 2018/7/24.
 */
@Data
public class User implements Serializable {

    private int id;

    private String username;


}
