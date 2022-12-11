package beans.ec.dss.entities;

public class rooms 
{
    private int roomno;
    private int capacity;

    public rooms(int roomno, int capacity) {
        this.roomno = roomno;
        this.capacity = capacity;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "rooms{" + "roomno=" + roomno + ", capacity=" + capacity + '}';
    }
    
}
