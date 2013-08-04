package com.stoyan.archery;

import java.util.List;

/**
 * Created by Stoyan Gaydarov on 7/31/13.
 */
public interface Storage {

    public Practice startNewPracticeRound();

    public Practice getPracticeRound(long id);

    /**
     * @return the practice object that was created last
     */
    public Practice getLastPracticeRound();

    public List<Score[]> getScores(Practice practice);

    public boolean appendScores(Practice practice, Score[] arrows);

}
