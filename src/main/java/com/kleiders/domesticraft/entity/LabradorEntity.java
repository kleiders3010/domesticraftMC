
package com.kleiders.domesticraft.entity;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

import java.util.List;

import com.kleiders.domesticraft.procedures.SittingCheckProcedure;
import com.kleiders.domesticraft.procedures.LabradorRightClickedOnEntityProcedure;
import com.kleiders.domesticraft.procedures.LabradorOnInitialEntitySpawnProcedure;
import com.kleiders.domesticraft.init.DomesticraftModEntities;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;

public class LabradorEntity extends TamableAnimal implements IAnimatable {
	public LabradorEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DomesticraftModEntities.LABRADOR.get(), world);
	}

	public LabradorEntity(EntityType<LabradorEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.BONE));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 2, (float) 10, false) {
			@Override
			public boolean canUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canUse() && SittingCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canContinueToUse() && SittingCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canUse() && SittingCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canContinueToUse() && SittingCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canUse() && SittingCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canContinueToUse() && SittingCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canUse() && SittingCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canContinueToUse() && SittingCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canUse() && SittingCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LabradorEntity.this.getX();
				double y = LabradorEntity.this.getY();
				double z = LabradorEntity.this.getZ();
				Entity entity = LabradorEntity.this;
				Level world = LabradorEntity.this.level;
				return super.canContinueToUse() && SittingCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, (float) 6));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason,
			@Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		LabradorOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level.isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
					? InteractionResult.sidedSuccess(this.level.isClientSide())
					: InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level.isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level.isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level.broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level.broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level.isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;

		LabradorRightClickedOnEntityProcedure.execute(world, entity);
		return retval;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		LabradorEntity retval = DomesticraftModEntities.LABRADOR.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.BONE).contains(stack.getItem());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.26);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		return builder;
	}
	private final AnimationFactory factory = new AnimationFactory(this);
 private long lastSwing;
    
   private PlayState predicate(AnimationEvent animationEvent) {
   	            animationEvent.getController().transitionLengthTicks = 3;
   


if (getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getBoolean("sitting") == true) {
            animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.labrador.sit", false).addAnimation("animation.labrador.sitting", true));
            this.lastSwing = level.getGameTime();
        } else if (this.lastSwing + 8L >= level.getGameTime()) {
              animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.labrador.unsit", false));
        }
       
      else if (animationEvent.isMoving())
            {
                   animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.labrador.walk"));
       } else
       {
           animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.labrador.idle"));
       }
        return PlayState.CONTINUE;
   }


	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
