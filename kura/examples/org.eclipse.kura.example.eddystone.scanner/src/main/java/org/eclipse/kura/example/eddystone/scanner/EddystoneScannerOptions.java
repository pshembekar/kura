/*******************************************************************************
 * Copyright (c) 2017 Eurotech and/or its affiliates
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.kura.example.eddystone.scanner;

import static java.util.Objects.requireNonNull;

import java.util.Map;

public class EddystoneScannerOptions {

    private static final String PROPERTY_ENABLE = "enable.scanning";
    private static final String PROPERTY_TOPIC_PREFIX = "topic.prefix";
    private static final String PROPERTY_INAME = "iname";
    private static final String PROPERTY_PUBLISH_PERIOD = "publish.period";
    private static final String PROPERTY_SCAN_DURATION = "scan.duration";

    private static final boolean PROPERTY_ENABLE_DEFAULT = false;
    private static final String PROPERTY_TOPIC_PREFIX_DEFAULT = "beacons";
    private static final String PROPERTY_INAME_DEFAULT = "hci0";
    private static final int PROPERTY_PUBLISH_PERIOD_DEFAULT = 10;
    private static final int PROPERTY_SCAN_DURATION_DEFAULT = 60;

    private final boolean enableScanning;
    private final String topicPrefix;
    private final String adapterName;
    private final int publishPeriod;
    private final int scanDuration;

    public EddystoneScannerOptions(Map<String, Object> properties) {
        requireNonNull(properties, "Required not null");
        this.enableScanning = getProperty(properties, PROPERTY_ENABLE, PROPERTY_ENABLE_DEFAULT);
        this.topicPrefix = getProperty(properties, PROPERTY_TOPIC_PREFIX, PROPERTY_TOPIC_PREFIX_DEFAULT);
        this.adapterName = getProperty(properties, PROPERTY_INAME, PROPERTY_INAME_DEFAULT);
        this.publishPeriod = getProperty(properties, PROPERTY_PUBLISH_PERIOD, PROPERTY_PUBLISH_PERIOD_DEFAULT);
        this.scanDuration = getProperty(properties, PROPERTY_SCAN_DURATION, PROPERTY_SCAN_DURATION_DEFAULT);
    }

    public boolean isEnabled() {
        return this.enableScanning;
    }

    public String getTopicPrefix() {
        return this.topicPrefix;
    }

    public String getAdapterName() {
        return this.adapterName;
    }

    public int getPublishPeriod() {
        return this.publishPeriod;
    }

    public int getScanDuration() {
        return this.scanDuration;
    }

    @SuppressWarnings("unchecked")
    private <T> T getProperty(Map<String, Object> properties, String propertyName, T defaultValue) {
        Object prop = properties.getOrDefault(propertyName, defaultValue);
        if (prop != null && prop.getClass().isAssignableFrom(defaultValue.getClass())) {
            return (T) prop;
        } else {
            return defaultValue;
        }
    }
}
