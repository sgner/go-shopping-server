import cn.hutool.core.util.RandomUtil;
import com.goShopping.utils.BasisUtil;
import com.goShopping.utils.ModeUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
@SpringBootTest
public class test {
    public static void main(String[] args) {
        System.out.println(ModeUtil.getSearchMode().get(2));
        System.out.println(BasisUtil.getBasis().get(3));
    }
}
