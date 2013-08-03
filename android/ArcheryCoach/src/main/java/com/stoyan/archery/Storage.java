package com.stoyan.archery;

import java.util.List;

/**
 * Created by Stoyan Gaydarov on 7/31/13.
 */
public interface Storage {

    public Practice startNewPracticeRound();

    public Practice getPracticeRound(long id);

    public List<Score[]> getScores(Practice practice);

    public boolean store(Practice practice, Score[] arrows);

}
