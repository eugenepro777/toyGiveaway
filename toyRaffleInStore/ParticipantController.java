package toyRaffleInStore;
import java.util.*;

public class ParticipantController {
    private PriorityQueue<ParticipantModel> participantsQueue;

    public ParticipantController() {
        this.participantsQueue = new PriorityQueue<>((a, b) -> b.getFrequency() - a.getFrequency());
    }

    public void addParticipant(ParticipantModel participant) {
        participantsQueue.add(participant);
    }

    public void addParticipant(List<ParticipantModel> participants) {
        participantsQueue.addAll(participants);
    }

    public void setFrequencyForParticipant(String id, int frequency) {
        for (ParticipantModel participant : participantsQueue) {
            if (participant.getId().equals(id)) {
                participant.setFrequency(frequency);
                return;
            }
        }
    }

    public List<String> getTenParticipants() {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ParticipantModel participant = participantsQueue.poll();
            if (participant == null) {
                break;
            }

            winners.add(participant.getName());
            participantsQueue.add(participant);
        }

        return winners;
    }
}
