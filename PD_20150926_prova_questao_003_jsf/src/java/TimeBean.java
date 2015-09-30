import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "timeBean")
@SessionScoped
public class TimeBean {
    private List<Time> times;
    private Time time;
    
    public TimeBean(){
        this.time = new Time();
        this.times = new ArrayList<Time>();
    }
    
    public void salvar(){
        if (this.time.getNumero() > 0){
            if (!this.times.contains(this.time)){
                this.times.add(time);
            } else {
                this.times.set(this.times.indexOf(this.time), this.time);
            }            
        }
        time = new Time();
    }
    
    public void apagaTime(Time _time){
        if (this.times.contains(_time)){
            this.times.remove(_time);
        }
    }
    
    public void editaTime(Time _time){
        if (this.times.contains(_time)){
            this.time = _time;
        }
    }

    public List<Time> getTimes() {
        return this.times;
    }

    public void setTimes(List<Time> _times) {
        this.times = _times;
    }
    
    public Time getTime(){
        return this.time;
    }
}
