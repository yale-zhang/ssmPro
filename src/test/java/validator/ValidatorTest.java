package validator;

import com.yale.ssm.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {
   private static Validator validator;

   @BeforeClass
    public static void setUp(){
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
   }
   @Test
   public void manufacturerIsNull(){
       User user = new User();
       Set<ConstraintViolation<User>> validate = validator.validate(user);
       assertEquals("userI不能为空",validate.iterator().next().getMessage());
   }
}
