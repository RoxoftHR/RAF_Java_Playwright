package RAF3kShared.Logging;

import java.time.Duration;
import java.util.ArrayList;

public class Step {
    public int stepNumber;
    public String stepName;
    public ArrayList<Substep> substeps = new ArrayList<Substep>();

    public Duration durations() {
        if(substeps.size()>0)
            return Duration.between(substeps.get(0).start, substeps.get(substeps.size() - 1).finish);

        return Duration.ofSeconds(0);
    }

    public Boolean bSuccess() {
        //return Substeps.Where(s => !s.Passed).ToList().Count == 0;
        return true;
    }
}
