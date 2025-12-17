package com.newsappde.data.remote.mapper

import com.newsappde.data.remote.dto.SourceDto
import com.newsappde.domain.model.SourceDomain
import com.newsappde.utils.baseMapper.BaseMapper

class SourceDomainToSourceDtoMapper : BaseMapper<SourceDomain, SourceDto> {
    override fun mapModel(model: SourceDomain): SourceDto {
        return with(model) {
            SourceDto(
                id = id,
                name = name
            )
        }
    }
}