class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean parked = false;

        for (int i = 0; i < 3; i++) {

            if (carType == 1) {
                for (int j = 0; j < big; j++) {
                    if (big > 0 && !parked) {
                        big--;
                        parked = true;
                        break;
                    }
                }
            }
            else if (carType == 2) {
                for (int j = 0; j < medium; j++) {
                    if (medium > 0 && !parked) {
                        medium--;
                        parked = true;
                        break;
                    }
                }
            }
            else if (carType == 3) {
                for (int j = 0; j < small; j++) {
                    if (small > 0 && !parked) {
                        small--;
                        parked = true;
                        break;
                    }
                }
            }

            if (parked) break;
        }

        return parked;
    }
}