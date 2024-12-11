package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuanle.vsocialbe.entity.PostEmoticon;

public interface PostEmoticonRepo extends JpaRepository<PostEmoticon, PostEmoticon.PostEmotionId> {
}
