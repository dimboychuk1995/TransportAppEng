package com.oblenergo.service;

import com.oblenergo.model.Orders;

public interface ItextService {

	public byte[] writeCheck(Orders orders);
}
