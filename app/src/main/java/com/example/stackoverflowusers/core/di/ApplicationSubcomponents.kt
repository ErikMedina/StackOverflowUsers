package com.example.stackoverflowusers.core.di

import com.example.stackoverflowusers.core.di.presentation.PresentationComponent
import dagger.Module

@Module(subcomponents = [PresentationComponent::class])
class ApplicationSubcomponents
