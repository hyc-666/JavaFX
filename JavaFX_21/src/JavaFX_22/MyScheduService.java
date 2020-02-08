package JavaFX_22;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class MyScheduService extends ScheduledService<Integer>{

    int i = 10;
    private DialogPane di;
    private Stage stage;

    public MyScheduService(DialogPane di, Stage stage) {
        this.di = di;
        this.stage = stage;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call:"+ Thread.currentThread().getName());
                return i--;//这里的返回值会传递给下面方法的value
            }

            @Override
            protected void updateValue(Integer value) {
                System.out.println("updateValue:" + Thread.currentThread().getName());
                System.out.println("Value: " + value);
                if(value > 0){
                    di.setContentText(String.valueOf(value));
                }else{
                    stage.close();
                    //这样关闭时关不掉的
                    //其实这里的this指的是上面的Task
//                    this.cancel();
                    MyScheduService.this.cancel();//必须要用类名调用才能关闭Task
                }
                super.updateValue(value);
            }
        };
    }
}
