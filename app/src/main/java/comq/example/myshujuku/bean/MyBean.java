package comq.example.myshujuku.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 囨囚囨図 on 2017/12/28.
 */
@Entity
public class MyBean {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    @Generated(hash = 154192404)
    public MyBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1281580447)
    public MyBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
