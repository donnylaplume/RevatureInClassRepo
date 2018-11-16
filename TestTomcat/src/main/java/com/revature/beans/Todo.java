package com.revature.beans;

import java.io.Serializable;

public class Todo implements Serializable {
	
		private String name;
		private int priority;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public Todo(String name, int priority) {
			super();
			this.name = name;
			this.priority = priority;
		}
		public Todo() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + priority;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Todo other = (Todo) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (priority != other.priority)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Todo [name=" + name + ", priority=" + priority + "]";
		}
		
		
}
