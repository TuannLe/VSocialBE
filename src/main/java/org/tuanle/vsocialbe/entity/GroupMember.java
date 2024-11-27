package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_group_member")
@Getter
@Setter
@NoArgsConstructor
public class GroupMember {
    @EmbeddedId
    private GroupMemberId groupMemberId;

    @Embeddable
    public static class GroupMemberId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "group_id")
        private Group groupId;

        @ManyToOne
        @JoinColumn(name = "account_id")
        private Account accountId;

        public GroupMemberId() {}

        public GroupMemberId(Group groupId, Account accountId) {
            this.groupId = groupId;
            this.accountId = accountId;
        }

        public Group getGroupId() {
            return groupId;
        }

        public void setGroupId(Group groupId) {
            this.groupId = groupId;
        }

        public Account getAccountId() {
            return accountId;
        }

        public void setAccountId(Account accountId) {
            this.accountId = accountId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GroupMemberId that = (GroupMemberId) o;
            return groupId == that.groupId && Objects.equals(accountId, that.accountId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(groupId, accountId);
        }
    }
}
