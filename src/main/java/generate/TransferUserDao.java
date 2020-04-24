package generate;

import generate.TransferUser;

public interface TransferUserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(TransferUser record);

    int insertSelective(TransferUser record);

    TransferUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TransferUser record);

    int updateByPrimaryKey(TransferUser record);
}