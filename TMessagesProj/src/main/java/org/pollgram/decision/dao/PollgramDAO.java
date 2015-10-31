package org.pollgram.decision.dao;

import android.support.annotation.Nullable;

import org.pollgram.decision.data.Option;
import org.pollgram.decision.data.Decision;
import org.pollgram.decision.data.UsersDecisionVotes;
import org.pollgram.decision.data.Vote;
import org.telegram.tgnet.TLRPC;

import java.util.Collection;
import java.util.List;

/**
 * Created by davide on 03/10/15.
 */
public abstract class PollgramDAO {

    public abstract Decision getDecision(long decisionId);

    public abstract List<Decision> getDecisions(@Nullable Boolean open);

    public abstract List<Option> getOptions(Decision decision);

    public abstract List<Option> getOptions(long decisionId);

    public abstract List<TLRPC.User> getUsers(int[] usersIds);

    public abstract List<Vote> getUserVoteForDecision(long decisionId, int userId);

    public abstract void save(Collection<Vote> votest2save);

    public abstract UsersDecisionVotes getUsersDecisionVotes(long decisionId, int[] participantIds);

    private static volatile PollgramDAO Instance = null;

    public static PollgramDAO getInstance() {
        PollgramDAO localInstance = Instance;
        if (localInstance == null) {
            synchronized (PollgramDAO.class) {
                localInstance = Instance;
                if (localInstance == null) {
                    Instance = localInstance = new PollgramDAOStubImpl();
                }
            }
        }
        return localInstance;
    }

}
