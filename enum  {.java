public enum LoanStatus {
    ONGOING, RETURNED, LATE;

    public boolean canTransitionTo(LoanStatus next) {
        return switch (this) {
            case ONGOING -> next == RETURNED || next == LATE;
            case LATE -> next == RETURNED;
            case RETURNED -> false;
        };
    }

    public boolean isActive() {
        return this == ONGOING || this == LATE;
    }
}
