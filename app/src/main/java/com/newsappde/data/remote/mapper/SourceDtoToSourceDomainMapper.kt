package com.newsappde.data.remote.mapper

import com.newsappde.data.remote.dto.SourceDto
import com.newsappde.domain.model.SourceDomain
import com.newsappde.utils.baseMapper.BaseMapper

class SourceDtoToSourceDomainMapper : BaseMapper<SourceDto, SourceDomain> {
    override fun mapModel(model: SourceDto): SourceDomain {
        return with(model) {
            SourceDomain(
                id = id,
                name = name
            )
        }
    }
}